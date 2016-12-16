package homework5_service.main;

import java.util.ArrayList;
import java.util.Collection;

import homework5_service.services.PostService;
import homework5_service.vo.PostVO;
import homework5_service.vo.UserVO;

public class Main {
    public static void main(String[] args){
        PostService service = new PostService();
        Collection<PostVO> postsVO = new ArrayList<>();
        PostVO postVO = new PostVO();
        postVO.setHeader("Header");
        postVO.setText("text");
        postVO.setUsername("Bela_ba");
        postVO.setDate("2016.12.14");
        String[] pics = {"retek", "pokemon", "pityu"};
        postVO.setTags(pics);
        service.save(postVO);
        System.out.println(service.findAll());
      /*  if(service.findAll()!=null)
       
            System.out.println("faja");
        
        postVO=service.findById(1);
        if(postVO!=null) System.out.println(postVO.toString());
        else System.out.println("rekt");
    */
    }
    
}
