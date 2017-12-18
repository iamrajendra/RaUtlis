package iamrajendra.io.RaUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import iamrajendra.io.models.Student;

/**
 * Created by gwl on 18/12/17.
 */

public class RaUtils {
    public  final static int ASENDING =0;
    public  final static int DESENDING =1;


    public static void remove(Collection collection, Object o) {
        while (collection.contains(o)) {
            collection.remove(o);
        }


    }

    public static void sort(Collection collection,String varialbeName,Sorter sorter) {



    }


    public static void sort(List list, final String name, int choice) {

        Comparator<Object> comparator=    new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int flag=-1;

                try {
                    String f = (String) o1.getClass().getDeclaredField(name).get(o1);
                    String f1 = (String) o2.getClass().getDeclaredField(name).get(o2);
                    flag = f.compareTo(f1);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }catch (ClassCastException e)
                {
                    Integer f = null;
                    try {
                        f = (Integer) o1.getClass().getDeclaredField(name).get(o1);
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    } catch (NoSuchFieldException e1) {
                        e1.printStackTrace();
                    }
                    Integer f1 = null;
                    try {
                        f1 = (Integer) o2.getClass().getDeclaredField(name).get(o2);
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    } catch (NoSuchFieldException e1) {
                        e1.printStackTrace();
                    }
                    flag = f.compareTo(f1);

                }

                return  flag;
            }
        };

        switch (choice)
        {

            case ASENDING:
                Collections.sort(list, comparator);
                break;
            case DESENDING:
                Collections.sort(list, Collections.reverseOrder(comparator));
                break;
        }



    }

    public  void range()
    {

    }


}
