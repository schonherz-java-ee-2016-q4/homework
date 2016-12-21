
package hu.schonherz.blog.service.api.user.vo;

import java.util.ArrayList;
import java.util.List;

public class UserResultVo {

	private List<UserVo> results = new ArrayList<UserVo>();
	private InfoVo info;
	
	public List<UserVo> getResults() {
		return results;
	}
	public void setResults(List<UserVo> results) {
		this.results = results;
	}
	public InfoVo getInfo() {
		return info;
	}
	public void setInfo(InfoVo info) {
		this.info = info;
	}

}
