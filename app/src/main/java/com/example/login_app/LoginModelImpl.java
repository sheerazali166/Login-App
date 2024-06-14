package com.example.login_app;

import android.os.AsyncTask;

import com.example.login_app.event.CanceledEvent;
import com.example.login_app.event.PasswordErrorEvent;
import com.example.login_app.event.SuccessEvent;

import org.greenrobot.eventbus.EventBus;

public class LoginModelImpl implements LoginModel{



    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[] {
            "test@galileo.edu:kinzachocolaty", "test2@galileo.edu:kinzacute"
    };
    private Void Void;


    @Override
    public void login(String username, String password) {

        new UserLoginTask(username, password).execute((Void) , null);
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        // jo kuti maan ban-ne ki keemat leke maan ban-ne se inkaar kare
        // uski gaand pe din raat subah sham namak laga kar korhe itne korhe barsao
        // itne korhe barsao k apni gaand ko hi bhool jaye illigal haq toh door ki baat
        // phir who chootyi easa ho ya is-real? isreal

        private final String email;
        private final String password;

        public UserLoginTask(String _email, String _password) {
            this.email = _email;
            this.password = _password;
        }


        @Override
        protected Boolean doInBackground(Void... voids) {

            // TODO: attempt authentication against a network service.
            try {
                // Simulate network access.
                Thread.sleep(2000);

            } catch (InterruptedException interruptedException) {
                return false;
            }

            for(String credentials: DUMMY_CREDENTIALS) {

                String pieces[] = credentials.split(":");

                if (pieces[0].equals(email)) {

                    // Account exists, return true if the password matches.
                    return pieces[1].equals(password);
                }


            }

            // TODO: register the new account here.
            return false;

        }

        @Override
        protected void onPostExecute(Boolean success) {


            if (success) {

                EventBus.getDefault().post(new SuccessEvent());

            } else {

                EventBus.getDefault().post(new PasswordErrorEvent(R.string.error_incorrect_password));
            }
        }

        @Override
        protected void onCancelled() {

            EventBus.getDefault().post(new CanceledEvent());
        }
    }
}
