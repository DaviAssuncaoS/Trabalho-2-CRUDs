export interface IProduct {
    id: number,
    name: string,
    description: string,
    barCode: string,
    productType: string,
    unitMeasurement: string,
    status: string
}

export interface ICreateProduct {
    name: string,
    description: string,
    barCode: string,
    productType: string,
    unitMeasurement: string
}