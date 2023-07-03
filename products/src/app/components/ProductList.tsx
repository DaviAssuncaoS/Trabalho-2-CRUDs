import { IProduct } from "../../../types/products"
import Product from "./Product"

interface ProductListProps {
    products: IProduct[]
}


const ProductList: React.FC<ProductListProps> = ({ products }) => {
    return (
        <div className="overflow-x-auto">
            <table className="table">
                {/* head */}
                <thead>
                    <tr>
                        <th></th>
                        <th>Nome</th>
                        <th>Tipo de produto</th>
                        <th>Unidade de medida</th>
                        <th>Status</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map(product => <Product key={product.id} product={product} />)}
                </tbody>
            </table>
        </div>
    )
}

export default ProductList