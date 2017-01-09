package vo;

import java.sql.Date;

public class PostVO {
    
        private String name;
        private String title;
        private String textArea;
        private Date date;
        
        public PostVO(){}
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTextArea() {
            return textArea;
        }
        public void setTextArea(String textArea) {
            this.textArea = textArea;
        }
        
        public Date getDate() {
            return date;
        }
        public void setDate(Date date) {
            this.date = date;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("PostDTO [name=");
            builder.append(name);
            builder.append(", title=");
            builder.append(title);
            builder.append(", textArea=");
            builder.append(textArea);
            builder.append(", date=");
            builder.append(date);
            builder.append("]");
            return builder.toString();
        }

        
        
        
    }

