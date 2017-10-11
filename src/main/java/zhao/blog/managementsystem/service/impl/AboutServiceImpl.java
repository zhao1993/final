package zhao.blog.managementsystem.service.impl;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.entity.BlogAbout;
import zhao.blog.managementsystem.service.AboutService;

@Service
@Transactional
public class AboutServiceImpl extends BaseServiceImpl<BlogAbout> implements AboutService {

}
