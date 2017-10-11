package zhao.blog.managementsystem.service.impl;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.entity.BlogSortArticle;
import zhao.blog.managementsystem.service.SortArticleService;

@Service
@Transactional
public class SortArticleServiceImpl extends BaseServiceImpl<BlogSortArticle> implements SortArticleService {

}
