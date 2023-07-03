import { IProduct, ICreateProduct } from "./types/products"

const baseURL = 'http://localhost:3000'

export const getAllProducts = async (): Promise<IProduct[]> => {
    const res = await fetch(`${baseURL}/api/v1/products`, {
        method: 'GET',
        cache: "no-cache",
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const response = await res.json();
    const data = response['data']
    const products = data['content']
    return products;
}

export const addProduct = async (product: ICreateProduct): Promise<IProduct> => {
    const res = await fetch(`${baseURL}/api/v1/products`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
    const newProduct = await res.json();
    return newProduct;
}