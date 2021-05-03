package au.edu.canberra.assignment1_u3165466;

import java.util.Date;

/**
 * Created by Tashvi G on 18/03/2017.
 */

public class ContactDetails {


    //class ContactDetails {
        String title;
        String text;
        Date date;

        public ContactDetails(String title, String text) {
            this.title = title;
            this.text = text;
            //this.date = date;
        }

        public String getTitle(){
            return this.title;
        }

        public String gettext(){
            return this.text;
        }

        //public String getDateString(){
            //return this.date.toString();
        //}

        @Override
        public String toString(){
            return title;

        }


    }


