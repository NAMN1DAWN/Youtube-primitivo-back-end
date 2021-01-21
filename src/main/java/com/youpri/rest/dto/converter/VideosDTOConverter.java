package com.youpri.rest.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.youpri.modelo.Videos;
import com.youpri.rest.dto.CreateVideos;
import com.youpri.rest.dto.VideosDTO;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class VideosDTOConverter {
	private final ModelMapper modelMapper = null;
	public VideosDTO convertToDto(Videos videos) {
		return modelMapper.map(videos, VideosDTO.class);
	}
	
	public Videos convertToVideos(CreateVideos createVideos) {
        return modelMapper.map(createVideos, Videos.class);
    }
}
