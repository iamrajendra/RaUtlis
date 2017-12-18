package iamrajendra.io.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import iamrajendra.io.R;
import iamrajendra.io.models.Student;

/**
 * Created by gwl on 18/12/17.
 */

public class SudentAdapter extends RecyclerView.Adapter<SudentAdapter.StudentView> {
    private List<Student>  mList;
    private Context mContext;

    public SudentAdapter(List<Student> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public SudentAdapter.StudentView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.student_adapter,null);


        return new StudentView(view);
    }

    @Override
    public void onBindViewHolder(SudentAdapter.StudentView holder, int position) {

        holder.mTextView_name.setText(mList.get(position).getName());
        holder.mTextView_age.setText(""+mList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class StudentView extends RecyclerView.ViewHolder {
        private TextView mTextView_name;
        private TextView mTextView_age;
        public StudentView(View itemView) {
            super(itemView);
            mTextView_name = itemView.findViewById(R.id.name_tv);
            mTextView_age  =itemView.findViewById(R.id.age_tv);
        }
    }
}
