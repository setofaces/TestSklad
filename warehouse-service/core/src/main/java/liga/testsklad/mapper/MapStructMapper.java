package liga.testsklad.mapper;

import liga.testsklad.dto.CategoryDto;
import liga.testsklad.dto.PositionDto;
import liga.testsklad.dto.SaleDto;
import liga.testsklad.dto.SupplyDto;
import liga.testsklad.model.Category;
import liga.testsklad.model.Position;
import liga.testsklad.model.Sale;
import liga.testsklad.model.Supply;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    SaleDto saleToSaleDto(Sale sale);

    Sale saleDtoToSale(SaleDto saleDto);

    List<SaleDto> salesToSaleDtos(List<Sale> sales);

    SupplyDto supplyToSupplyDto(Supply supply);

    Supply supplyDtoToSupply(SupplyDto supplyDto);

    List<SupplyDto> suppliesToSupplyDtos(List<Supply> supplies);

    CategoryDto categoryToCategoryDto(Category category);

    Category categoryDtoToCategory(CategoryDto categoryDto);

    List<CategoryDto> categoriesToCategoryDtos(List<Category> categories);

    PositionDto positionToPositionDto(Position position);

    Position positionDtoToPosition(PositionDto positionDto);

    List<PositionDto> positionsToPositionDtos(List<Position> positions);
}
