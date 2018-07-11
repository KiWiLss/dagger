package com.kiwilss.dagger.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kiwilss.dagger.R;

/**
 * FileName: DialogFragmentTestActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/11
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class DialogFragmentTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);



    }

    public void alertdialogListener(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("简单标题")
                .setMessage("简单的消息")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setPositiveButton("很好", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .show();
    }

    public void dialogfragmentListener(View view) {
        EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
        editNameDialog.show(getSupportFragmentManager(), "EditNameDialog");

    }
}
