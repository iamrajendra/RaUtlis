package iamrajendra.io;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import iamrajendra.io.RaUtils.RaUtils;
import iamrajendra.io.adapter.SudentAdapter;
import iamrajendra.io.models.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private SudentAdapter mStudentAdapter;
    private List<Student> mList;
    private Button mButton_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();
        mList.add(new Student("Rajendra", 31));
        mList.add(new Student("Jitendra", 35));
        mList.add(new Student("Riya", 25));
        mList.add(new Student("Jiya", 36));
        mList.add(new Student("Miya", 37));
        mList.add(new Student("Tiya", 38));


        mStudentAdapter = new SudentAdapter(mList, this);
        mRecyclerView = findViewById(R.id.list);
        mButton_remove = findViewById(R.id.remove_b);
        mButton_remove.setOnClickListener(this);
        mRecyclerView.setAdapter(mStudentAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onClick(View v) {
        Student student = new Student();
        student.select("name", student.getClass()).rContatins("end");

      RaUtils.remove(mList,student);
//        RaUtils.sort(mList,"name",RaUtils.ASENDING);
        mRecyclerView.getAdapter().notifyDataSetChanged();

    }
}
