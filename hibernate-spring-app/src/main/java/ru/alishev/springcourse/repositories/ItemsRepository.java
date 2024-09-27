package ru.alishev.springcourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.alishev.springcourse.models.Item;
import ru.alishev.springcourse.models.Person;

@Repository
public interface ItemsRepository extends JpaRepository<Item,Integer> {
	
	List<Item> findByItemName(String itemName);
	
	
	List<Item> findByOwner(Person owner);

}
