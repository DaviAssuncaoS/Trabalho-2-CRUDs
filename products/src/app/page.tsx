import { getAllProducts } from "../../api";
import AddProduct from "./components/AddProduct";
import ProductList from "./components/ProductList";

export default async function Home() {

  const products = await getAllProducts();
  console.log(products);

  return (
    <main className="max-w-4xl mx-auto mt-4">
      <div className="text-center my-5 flex flex-col gap-4">
        <h1 className="text-2xl font-bold">Products App</h1>
        <AddProduct />
      </div>
      <ProductList products={products} />
    </main>
  )
}
