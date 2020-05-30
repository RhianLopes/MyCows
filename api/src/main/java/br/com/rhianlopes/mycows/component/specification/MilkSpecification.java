package br.com.rhianlopes.mycows.component.specification;

import br.com.rhianlopes.mycows.controller.find.request.FindAllMilkFilterRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Milk;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

/**
 * @author rhian.costa
 */
@Component
public class MilkSpecification {

    public Specification<Milk> byFilter(FindAllMilkFilterRequestDto requestDto, Cow cow) {

    }
}
