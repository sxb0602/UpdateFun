package cn.hugeterry.updatefun.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.hugeterry.updatefun.config.DownloadKey;
import cn.hugeterry.updatefun.config.UpdateKey;
import cn.hugeterry.updatefun.R;
import cn.hugeterry.updatefun.module.Download;
import cn.hugeterry.updatefun.utils.GetAppInfo;


public class DownLoadDialog extends Activity {
    private ImageView close;
    private ProgressBar mProgress;
    private TextView count;

    private Context mContext = DownloadKey.FROMACTIVITY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_dialog);

        close = (ImageView) findViewById(R.id.downloaddialog_close);
        mProgress = (ProgressBar) findViewById(R.id.downloaddialog_progress);
        count= (TextView) findViewById(R.id.downloaddialog_count);

        new Download(this, mProgress,count).start();

        close.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(DownLoadDialog.this,
                        mContext.getClass());
                setResult(3, intent);
                DownloadKey.TOShowDownloadView = 1;
                DownloadKey.interceptFlag = true;
                finish();
            }
        });

    }


}
