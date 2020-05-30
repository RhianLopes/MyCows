package br.com.rhianlopes.mycows.component.specification;

import br.com.rhianlopes.mycows.controller.find.request.FindAllMilkFilterRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Milk;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rhian.costa
 */
@Component
public class MilkSpecification {

    public Specification<Milk> byFilter(FindAllMilkFilterRequestDto requestDto, Cow cow) {

        return ((Root<Milk> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            final LocalDate today = LocalDate.now();

            predicates.add(builder.equal(root.get("cow").as(Cow.class), cow));

            if (requestDto.getInitialDate() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("updatedAt"), requestDto.getInitialDate().atTime(LocalTime.MIN)));
            } else {
                predicates.add(builder.greaterThanOrEqualTo(root.get("updatedAt"), today.atTime(LocalTime.MIN)));
            }
            if (requestDto.getFinalDate() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("updatedAt"), requestDto.getFinalDate().atTime(LocalTime.MAX)));
            } else {
                predicates.add(builder.lessThanOrEqualTo(root.get("updatedAt"), today.atTime(LocalTime.MAX)));
            }
            return builder.and(predicates.toArray(new Predicate[]{}));
        });
    }
}
