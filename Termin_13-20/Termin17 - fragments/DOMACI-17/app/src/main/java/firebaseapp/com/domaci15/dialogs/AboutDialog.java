package firebaseapp.com.domaci15.dialogs;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class AboutDialog extends AlertDialog.Builder {


    public AboutDialog(Context context) {
        super(context);
        setTitle("About Dialog Class");
        setMessage("This is an example of a dialog");
        setCancelable(false);
        setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                // listener za ok dugme
            }

        });
        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }

    public AlertDialog prepareDialog(){
        AlertDialog dialog = create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

}
