package model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class XElement implements Element {
   String name;
}
