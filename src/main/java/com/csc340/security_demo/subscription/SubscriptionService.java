package com.csc340.security_demo.subscription;

import com.csc340.security_demo.article.ArticleRepository;
import com.csc340.security_demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepo;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepo.findAll();
    }

    public Subscription getSubscriptionById(long id) {
        return subscriptionRepo.getReferenceById(id);
    }

    public List<Subscription> getSubscriptionByArticleId(long id) {
        return subscriptionRepo.getSubscriptionByArticleId(id);
    }

    public Subscription getOneSubscription(long articleId, long userId) {
        return subscriptionRepo.getOneSubscription(articleId, userId);
    }


    public void addNewSubscription(long articleId, long userId) {
        Subscription sub = new Subscription(userRepository.getReferenceById(userId),
                articleRepository.getReferenceById(articleId));

        subscriptionRepo.save(sub);
    }

    public List<Subscription> getSubscriptionsByUser(long userId) {
        return subscriptionRepo.getSubscriptionsByCustomer(userId);
    }

    public void removeSub(long id) {
        subscriptionRepo.deleteById(id);
    }
}
