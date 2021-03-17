package course.labs.changeratecurrentcy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CreadentialDialog extends DialogFragment {
  EditText txtUserName;
  EditText txtPassword;
  ICredentialsDialogListener listener;

  public interface ICredentialsDialogListener {
    void onDialogPositiveClick(String username, String password);
  }

  @Override
  public void onAttach(@NonNull Context context) {
   super.onAttach(context);
   if(getActivity() instanceof  ICredentialsDialogListener){
     listener = (ICredentialsDialogListener) getActivity();
   }
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_credentials, null);

    txtUserName = (EditText) view.findViewById(R.id.username_edittext);
    txtPassword = (EditText) view.findViewById(R.id.password_edittext);

    txtUserName.setText(getArguments().getString("username"));
    txtPassword.setText(getArguments().getString("password"));
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
        .setView(view)
        .setTitle("Credentials")
        .setNegativeButton("Cancel", null)
        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            if(listener != null){
              listener.onDialogPositiveClick(txtUserName.getText().toString(), txtPassword.getText().toString());
            }
          }
        });

    return builder.create();
  }
}
