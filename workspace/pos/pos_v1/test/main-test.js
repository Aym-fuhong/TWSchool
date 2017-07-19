'use strict';

describe('pos', () => {

  it('should renturn one object', () => {
    const element = 8;
    const collection = [{barcode: 1}, {barcode: 8}];
    expect(findOne(element, collection)).toEqual({barcode: 8});
  });

  it('should return splitedCollection', () => {
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
    const splitedCollection = [
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000003', count: 2.5},
      {barcode: 'ITEM000005', count: 1},
      {barcode: 'ITEM000005', count: 2}];
    expect(splitCollection(tags)).toEqual(splitedCollection);

  });

  it('should return formattedCollection', () => {
    const splitedCollection = [
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000001', count: 1},
      {barcode: 'ITEM000003', count: 2.5},
      {barcode: 'ITEM000005', count: 1},
      {barcode: 'ITEM000005', count: 2}];
    const formattedCollection = [
      {barcode: 'ITEM000001', count: 5},
      {barcode: 'ITEM000003', count: 2.5},
      {barcode: 'ITEM000005', count: 3},
    ];
    expect(getItemCount(splitedCollection)).toEqual(formattedCollection);

  });

  it('should return formattedCollection', () => {
    const formattedCollection = [
      {barcode: 'ITEM000001', count: 5},
    ];
    const collectionInfo = [
      {
        barcode: 'ITEM000001',
        count: 5,
        name: '雪碧',
        price: 3.00,
        unit: '瓶'
      }];
    expect(getItemsInfo(formattedCollection)).toEqual(collectionInfo);

  });


  it('should return addTypeOfPromotionItem', () => {
    const formattedCollection = [
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
    const collectionInfo = [
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
    expect(addTypeOfPromotionItem(formattedCollection)).toEqual(collectionInfo);

  });

  it('should return itemPriceOfCollection', () => {
    const collectionInfo = [
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
    const itemPriceCollection = [
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
    expect(getItemPrice(collectionInfo)).toEqual(collectionInfo);

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

    spyOn(console, 'log');

    printReceipt(tags);

    const expectText = `***<没钱赚商店>收据***
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
