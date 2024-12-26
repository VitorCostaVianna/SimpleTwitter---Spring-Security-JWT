package com.vitor.springsecurity.controller.dto;

import java.util.List;

public record FeedDto(List<FeedItemDto> feedItemns,
                        int page,
                        int pafeSize,
                        int totalPages,
                        long totalElements) {  
    
}
