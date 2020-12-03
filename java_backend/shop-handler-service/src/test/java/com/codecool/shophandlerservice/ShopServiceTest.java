package com.codecool.shophandlerservice;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.repository.ItemRepository;
import com.codecool.shophandlerservice.service.ShopService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShopServiceTest {

	@Autowired
	private ShopService shopService;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	void getNewItemByCharacterIdAndCharacterLevelIsSaving() {
		shopService.getNewItemByCharacterIdAndCharacterLevel(1L,10L);
		int size=itemRepository.findAll().size();

		assertThat(size).isEqualTo(1);
	}

	@Test
	void getNewItemByCharacterIdAndCharacterLevelIsSavingMultipleTimes() {
		shopService.getNewItemByCharacterIdAndCharacterLevel(1L,1L);
		shopService.getNewItemByCharacterIdAndCharacterLevel(1L,5L);
		shopService.getNewItemByCharacterIdAndCharacterLevel(3L,1L);

		int size=itemRepository.findAll().size();

		assertThat(size).isEqualTo(3);
	}
	@Test
	void getNewItemByCharacterIdAndCharacterLevelItemIdIsNotNull() {
		shopService.getNewItemByCharacterIdAndCharacterLevel(1L,1L);

		Item item=itemRepository.findAll().get(0);

		assertThat(item.getId()).isNotNull();
	}

	@Test
	void getNewItemByCharacterIdAndCharacterLevelCharacterIdIsNotNull() {
		shopService.getNewItemByCharacterIdAndCharacterLevel(1L,1L);

		Item item=itemRepository.findAll().get(0);

		assertThat(item.getCharacterId()).isNotNull();
	}

	@Test
	void getNewItemByCharacterIdAndCharacterLevelCharacterIdIsEqualsToParameter() {
		shopService.getNewItemByCharacterIdAndCharacterLevel(1L,1L);

		Item item=itemRepository.findAll().get(0);

		assertThat(item.getCharacterId()).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(longs = {1, 1, 5, 3, 7})
	void getNewItemByCharacterIdAndCharacterLevelCharacterIdsAreEqualsToParameters(Long characterId) {
		shopService.getNewItemByCharacterIdAndCharacterLevel(characterId,1L);

		int iteration=itemRepository.findAll().size()-1;
		Item item=itemRepository.findAll().get(iteration);

		assertThat(item.getCharacterId()).isEqualTo(characterId);
	}

}