package ru.topjava.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.topjava.voting.model.Dish;
import ru.topjava.voting.model.Restaurant;
import ru.topjava.voting.repository.DishRepository;
import ru.topjava.voting.repository.RestaurantRepository;
import ru.topjava.voting.util.ValidationUtil;

import java.time.LocalDateTime;
import java.util.List;

import static ru.topjava.voting.util.ValidationUtil.checkNotFoundWithId;

@Service("dishService")
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @CacheEvict(value = "restaurants", allEntries = true)
    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalArgumentException("Restaurant is not found by id: " + restaurantId));
        dish.setRestaurant(restaurant);
        if (dish.getDate() == null) {
            dish.setDate(LocalDateTime.now());
        }
        return dishRepository.save(dish);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void delete(int id, int restId) {
        dishRepository.delete(id, restId);
    }

    public Dish get(int id, int restId) {
        return dishRepository.get(id, restId).orElseThrow(() -> new IllegalArgumentException("Dish is not found by id: " + id));
    }

    @Transactional
    @CacheEvict(value = "restaurants", allEntries = true)
    public Dish update(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        dish.setRestaurant(restaurantRepository.getOne(restaurantId));
        ValidationUtil.checkNotFoundWithId(dishRepository.save(dish), dish.getId());
        return dish;

    }

    public List<Dish> getAll(int restId) {
        return dishRepository.getAll(restId).orElseThrow(() -> new IllegalArgumentException("not found dishes with restaurant id: " + restId));
    }
}