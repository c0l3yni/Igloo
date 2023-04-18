import Item from "./Item";

export default function ItemsRegion({ items, increment }) {
  function getCartItems() {
    if (!items) {
      return;
    }
    return items.map((item) => (
      <Item item={item} key={item.product.id} increment={increment} />
    ));
  }

  return <div id="items-region">{getCartItems()}</div>;
}
