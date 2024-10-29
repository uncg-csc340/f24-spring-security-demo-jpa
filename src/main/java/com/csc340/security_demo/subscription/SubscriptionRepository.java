package com.csc340.security_demo.subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query(value = "select * from subscriptions where customer_id = :userId", nativeQuery = true)
    List<Subscription> getSubscriptionsByCustomer(long userId);

    @Query(value = "select * from subscriptions where article_id = :articleId", nativeQuery = true)
    List<Subscription> getSubscriptionByArticleId(long articleId);

    @Query(value = "select * from subscriptions where article_id = :articleId and customer_id = :customerId", nativeQuery = true)
    Subscription getOneSubscription(long articleId, long customerId);
}
