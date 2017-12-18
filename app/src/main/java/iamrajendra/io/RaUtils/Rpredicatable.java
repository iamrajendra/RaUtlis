package iamrajendra.io.RaUtils;


import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by gwl on 14/12/17.
 */

public class Rpredicatable implements Rpredicate<Rpredicatable> {

    private final String TAG = "Rpredicatable";
    private String varialbeName;
    private Object mEquals;
    private int greater = -1;
    private int smaller = -1;
    private Class mClass;
    private Object mClass1;
    private Object mContains;
    private boolean inverse =false;



    @Override
    public boolean equals(Object obj) {
        Log.i(TAG, "equals: ");

        boolean flag = false;
        if (varialbeName == null) {
            super.equals(obj);
        } else {
            mClass1 = convertInstanceOfObject(obj, mClass);
if(mContains !=null)
{
    String s = null;
    try {
        s = (String) mClass1.getClass().getDeclaredField(varialbeName).get(mClass1);
    } catch (NoSuchFieldException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (ClassCastException e) {
        try {
            s = String.valueOf(mClass1.getClass().getDeclaredField(varialbeName).get(mClass1));
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        }
    }
    flag = s.contains((String) mContains) ;

}
            else if (mEquals != null) {
                String s = null;
                try {
                    s = (String) mClass1.getClass().getDeclaredField(varialbeName).get(mClass1);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassCastException e) {
                    try {
                        s = String.valueOf(mClass1.getClass().getDeclaredField(varialbeName).get(mClass1));
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    } catch (NoSuchFieldException e1) {
                        e1.printStackTrace();
                    }
                }
                flag = s.equals(mEquals);
            } else if (greater != -1) {
                int num = 0;
                try {
                    num = (int) mClass1.getClass().getDeclaredField(varialbeName).get(mClass1);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                if (num > greater) {
                    flag = true;
                } else {
                    flag = false;

                }

            } else if (smaller != -1) {
                int num = 0;
                try {
                    num = (int) mClass1.getClass().getDeclaredField(varialbeName).get(mClass1);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                if (num < smaller) {
                    flag = true;
                } else {
                    flag = false;

                }

            }


        }

        return flag  ;
    }


    @Override
    public Rpredicatable select(String name, Class aClass) {
        varialbeName = name;
        mClass = aClass;
        return this;
    }

    @Override
    public Rpredicatable greaterThen(int i) {
        greater = i;
        return this;
    }

    @Override
    public Rpredicatable smallerThen(int i) {
        smaller = i;
        return this;
    }

    @Override
    public Rpredicatable rEqualTo(Object o) {
        mEquals = o;
        return this;
    }

    @Override
    public Rpredicatable rContatins(Object o) {
        mContains =o;
        return this;
    }

    @Override
    public Rpredicatable inverse() {
        inverse =true;
        return this;
    }

    public <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch (ClassCastException e) {
            return null;
        }
    }




}
