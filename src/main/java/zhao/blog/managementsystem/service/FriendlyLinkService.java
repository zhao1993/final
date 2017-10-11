/**
 * 
 */
package zhao.blog.managementsystem.service;

import zhao.blog.managementsystem.entity.BlogFriendlyLink;
import zhao.blog.managementsystem.entity.BlogUser;

public interface FriendlyLinkService extends BaseService<BlogFriendlyLink> {

	/**是否存在的链接
	 * @param linkUrl 需要查询的url
	 * @return 存在返回true
	 */
	boolean isExistUrl(String linkUrl);

	/**
	 * 申请友链
	 * @param user 申请用户
	 * @param link 链接对象
	 */
	void applyLink(BlogUser user,BlogFriendlyLink link);
	
}
