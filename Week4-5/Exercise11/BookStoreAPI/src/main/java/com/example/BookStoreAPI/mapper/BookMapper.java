package com.example.BookStoreAPI.mapper;

import com.example.BookStoreAPI.dto.BookDTO;
import com.example.BookStoreAPI.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);
    Book toEntity(BookDTO bookDTO);
}
