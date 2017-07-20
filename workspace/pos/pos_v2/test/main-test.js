'use strict';

describe('pos', () => {

  it('should return splitedTags', () => {
    const tags = [
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000003-2.5',
      'ITEM000005',
      'ITEM000005-2',
    ];
    const splitedTags = [
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000003', count: 2.5},
      {barcode: 'ITEM000005', count: 1},
      {barcode: 'ITEM000005', count: 2}];
    expect(splitTags(tags)).toEqual(splitedTags);

  });

  it('should return formattedCollection', () => {
    const splitedTags = [
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000003', count: 2.5},
      {barcode: 'ITEM000005', count: 1},
      {barcode: 'ITEM000005', count: 2}];
    const formattedTags = [
      {barcode: 'ITEM000001', count: 5},
      {barcode: 'ITEM000003', count: 2.5},
      {barcode: 'ITEM000005', count: 3},
    ];
    expect(getItemsCount(splitedTags)).toEqual(formattedTags);

  });


  it('should return cartItems', () => {
    const formattedTags = [
      {barcode: 'ITEM000001', count: 5}
    ];
    const cartItems = [
      {
        barcode: 'ITEM000001',
        count: 5,
        name: '雪碧',
        price: 3.00,
        unit: '瓶'
      }];
    let items= Item.all();
    expect(getCartItems(formattedTags, items)).toEqual(cartItems);

  });

  it('should return addTypeOfPromotionItem', () => {
    const cartItems = [
      {
        barcode: 'ITEM000001',
        count: 5,
        name: '雪碧',
        price: 3.00,
        unit: '瓶'
      },
      {
        barcode: 'ITEM000004',
        name: '电池',
        unit: '个',
        price: 2.00,
        count: 1
      }];
    const itemsPromotionsType = [
      {
        barcode: 'ITEM000001',
        count: 5,
        name: '雪碧',
        price: 3.00,
        unit: '瓶',
        'type': 'BUY_TWO_GET_ONE_FREE'
      },
      {
        barcode: 'ITEM000004',
        name: '电池',
        unit: '个',
        price: 2.00,
        count: 1
      }];
    let promotioms = Promotion.all();
    expect(getItemsPromotionType(cartItems, promotioms)).toEqual(itemsPromotionsType);

  });

  it('should return itemsPrice', () => {
    const cartItems = [
      {
        barcode: 'ITEM000001',
        count: 5,
        name: '雪碧',
        price: 3.00,
        unit: '瓶',
        'type': 'BUY_TWO_GET_ONE_FREE'
      },
      {
        barcode: 'ITEM000004',
        name: '电池',
        unit: '个',
        price: 2.00,
        count: 4
      }];
    const itemsPrice = [
      {
        barcode: 'ITEM000001',
        count: 5,
        name: '雪碧',
        price: 3.00,
        unit: '瓶',
        type: 'BUY_TWO_GET_ONE_FREE',
        itemPrice: 12.00
      },
      {
        barcode: 'ITEM000004',
        name: '电池',
        unit: '个',
        price: 2.00,
        count: 4,
        itemPrice: 8.00
      }];
    expect(getItemsPrice(cartItems)).toEqual(itemsPrice);

  });

  it('should print text', () => {

    const tags = [
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000003-2.5',
      'ITEM000005',
      'ITEM000005-2',
    ];

    const dateDigitToString = num => (num < 10 ? `0${num}` : num);

    spyOn(console, 'log');

    printReceipt(tags);

    const currentDate = new Date(),
      year = dateDigitToString(currentDate.getFullYear()),
      month = dateDigitToString(currentDate.getMonth() + 1),
      date = dateDigitToString(currentDate.getDate()),
      hour = dateDigitToString(currentDate.getHours()),
      minute = dateDigitToString(currentDate.getMinutes()),
      second = dateDigitToString(currentDate.getSeconds()),
      formattedDateString = `${year}年${month}月${date}日 ${hour}:${minute}:${second}`;

    const expectText = `***<没钱赚商店>收据***
打印时间：${formattedDateString}
----------------------
名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
----------------------
总计：58.50(元)
节省：7.50(元)
**********************`;

    expect(console.log).toHaveBeenCalledWith(expectText);
  });
});
