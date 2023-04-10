
package io.inugami.springboot.demo.user.search.api.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class UpdatedUserEvent {
    private Long id;
}
