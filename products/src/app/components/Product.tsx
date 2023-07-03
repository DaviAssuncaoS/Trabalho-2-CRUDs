import { IProduct } from "../../../types/products"
import { FiEdit } from "react-icons/fi"
import { BiBlock } from "react-icons/bi";

interface ProductProps {
    product: IProduct
}

const Product: React.FC<ProductProps> = ({ product }) => {
    return (
        <tr key={product.id}>
            <th>{product.id}</th>
            <td>{product.name}</td>
            <td>{product.productType}</td>
            <td>{product.unitMeasurement}</td>
            <td>{product.status}</td>
            <td className="flex gap-5">
                <FiEdit className="text-blue-500" size={25} />
                <BiBlock className="text-red-500" size={25} />
            </td>
        </tr>
    )
}

export default Product