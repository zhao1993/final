package zhao.blog.managementsystem.service.impl;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.entity.BlogFriendlyLink;
import zhao.blog.managementsystem.entity.BlogUser;
import zhao.blog.managementsystem.service.FriendlyLinkService;
import zhao.blog.managementsystem.util.EmailUtil;

@Service
@Transactional
public class FriendlyLinkServiceImpl extends BaseServiceImpl<BlogFriendlyLink> implements FriendlyLinkService {

	@Override
	public boolean isExistUrl(String linkUrl) {
		return select4PageByColumn(1, 5, "linkUrl", linkUrl).size()>0;
	}

	@Override
	public void applyLink(BlogUser user,BlogFriendlyLink link) {
		String html = 
				 "友情链接申请:<br><br> "
				+ "网站名称:"+link.getLinkName()
				+ "网站地址 :<a href='"+link.getLinkUrl()+"'>"+link.getLinkUrl()+"</a><br>      &nbsp;&nbsp;&nbsp;&nbsp;"
				+ "网站描述:"+link.getLinkDescript()+"<br> ";
		EmailUtil.sendEmail(user.getUserName(),"zqdbyc@163.com", "友情链接申请", "个人技术博客-友情链接申请",html);
	}
	
}
