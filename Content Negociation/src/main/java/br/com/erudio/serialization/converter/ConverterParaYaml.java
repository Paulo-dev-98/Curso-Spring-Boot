package br.com.erudio.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class ConverterParaYaml extends AbstractJackson2HttpMessageConverter{

	public ConverterParaYaml() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
	}

}
