package bonaguasato.gui;

/**
 * Created by kouichisato on 1/31/17.
 */

public class Users {


        //private variables
        int _id; // Just to have it.
        String _userName;
        String _passWord;

        // Empty constructor
        public Users(){

        }
        // constructor
        public Users(String username, String password){
            this._userName = username;
            this._passWord = password;
        }
        // getting User
        public String getUser(){
            return this._userName;
        }

        // getting Password
        public String getPassword(){
            return this._passWord;
        }
    }

