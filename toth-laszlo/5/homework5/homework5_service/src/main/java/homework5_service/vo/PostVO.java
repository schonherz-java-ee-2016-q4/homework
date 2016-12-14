package homework5_service.vo;

import java.util.Arrays;

public class PostVO {

        private int id;
        private String header, text, username, date;
        private String[] tags;
        
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public String[] getTags() {
            return tags;
        }
        public void setTags(String[] tags) {
            this.tags = tags;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getHeader() {
            return header;
        }
        public void setHeader(String header) {
            this.header = header;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        @Override
        public String toString() {
            return "PostVO [id=" + id + ", header=" + header + ", text=" + text + ", username=" + username + ", date="
                    + date + ", tags=" + Arrays.toString(tags) + "]";
        }
  

        
    

}
