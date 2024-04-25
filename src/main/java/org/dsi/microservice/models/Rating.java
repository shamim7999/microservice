package org.dsi.microservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String id;
    private String userId;
    private String hotelId;
    private Integer rating;
    private String feedback;
}
