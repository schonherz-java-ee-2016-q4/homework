package hu.sconherz.blog.web.post;

import javax.servlet.http.HttpServletRequest;

public class PostForm {
    private String name;
    private String title;
    private String textArea;
    
    public PostForm(HttpServletRequest request){
        name = request.getParameter("blogFormName");
        title = request.getParameter("blogFormTitle");
        textArea = request.getParameter("blogFormPost");
    }

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
    
    
}
