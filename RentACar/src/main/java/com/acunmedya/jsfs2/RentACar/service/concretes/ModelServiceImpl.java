package com.acunmedya.jsfs2.RentACar.service.concretes;

import com.acunmedya.jsfs2.RentACar.entitiy.Model;
import com.acunmedya.jsfs2.RentACar.repository.ModelRepository;
import com.acunmedya.jsfs2.RentACar.service.abstracts.ModelService;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.GetListModelResponse;
import com.acunmedya.jsfs2.RentACar.service.mappers.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public CreatedModelResponse add(CreateModelRequest request) {
        Model model = ModelMapper.INSTANCE.modelFromCreateModelRequest(request);
        Model createdModel = modelRepository.save(model);
        CreatedModelResponse response = ModelMapper.INSTANCE.createdModelResponseFromModel(createdModel);
        return response;
    }

    @Override
    public List<GetListModelResponse> getList() {
        List<Model> models = modelRepository.findAll();
        List<GetListModelResponse> responses = models.stream()
                .map(model -> ModelMapper.INSTANCE.getListModelResponseFromModel(model)).
                collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetListModelResponse> getByBrandName(String brandName) {
        List<Model> models = modelRepository.findByBrandName(brandName);
        List<GetListModelResponse> responses = models.stream()
                .map(model -> ModelMapper.INSTANCE.getListModelResponseFromModel(model)).
                collect(Collectors.toList());
        return responses;
    }
}
