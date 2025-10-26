package br.com.muniz.service;

import br.com.muniz.exception.NotFoundException;
import br.com.muniz.model.Person;
import br.com.muniz.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Finding All person");
        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finds a person by their id");
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No records for this id"));
    }

    public Person create(Person person){
        logger.info("Creating a person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating a person records");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new NotFoundException("No records for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAge(person.getAge());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting a person");
        Person entity = repository.findById(id).orElseThrow(() -> new NotFoundException("No records for this id"));
        repository.delete(entity);
    }
}
