"use client"

import { AiOutlinePlus } from 'react-icons/ai'
import Modal from './Modal'
import { FormEventHandler, useState } from 'react';
import { addProduct } from '../../../api';
import { useRouter } from 'next/navigation';

const AddProduct = () => {

    const router = useRouter();
    const [modalOpen, setModalOpen] = useState<boolean>(false);
    const [newProductNameValue, setNewProductNameValue] = useState<string>("");
    const [newProductDescriptionValue, setNewProductDescriptionValue] = useState<string>("");
    const [newProductBarCodeValue, setNewProductBarCodeValue] = useState<string>("");
    const [newProductTypeValue, setNewProductTypeValue] = useState<string>("");
    const [newProductUnitValue, setNewProductUnitValue] = useState<string>("");


    const handleSubmitNewProduct: FormEventHandler<HTMLFormElement> = async (e) => {
        e.preventDefault();
        await addProduct({
            name: newProductNameValue,
            description: newProductDescriptionValue,
            barCode: newProductBarCodeValue,
            productType: newProductTypeValue,
            unitMeasurement: newProductUnitValue
        })

        setNewProductNameValue("");
        setNewProductDescriptionValue("");
        setNewProductBarCodeValue("");
        setNewProductTypeValue("");
        setNewProductUnitValue("");
        setModalOpen(false);
        router.refresh();
    }

    return (
        <div>
            <button onClick={() => setModalOpen(true)} className="btn btn-primary w-full">
                Adicionar novo produto <AiOutlinePlus size={18} />
            </button>

            <Modal modalOpen={modalOpen} setModalOpen={setModalOpen}>
                <form onSubmit={handleSubmitNewProduct}>
                    <div className='flex-col items-center p-5'>
                        <h3 className='font-bold text-lg'>Adicionar novo produto</h3>
                        <div className='grid gap-4 grid-cols-1 grid-rows-5'>
                            <input value={newProductNameValue} onChange={e => setNewProductNameValue(e.target.value)} type="text" placeholder="Nome" className="input input-bordered w-full" />
                            <input value={newProductDescriptionValue} onChange={e => setNewProductDescriptionValue(e.target.value)} type="text" placeholder="Descrição" className="input input-bordered w-full" />
                            <input value={newProductBarCodeValue} onChange={e => setNewProductBarCodeValue(e.target.value)} type="text" placeholder="Código de barras" className="input input-bordered w-full" />
                            <select value={newProductTypeValue} onChange={e => setNewProductTypeValue(e.target.value)} className="select w-full">
                                <option disabled selected>Tipo do produto</option>
                                <option>VESTUARIO</option>
                                <option>ALIMENTACAO</option>
                                <option>ELETRONICO</option>
                            </select>
                            <select value={newProductUnitValue} onChange={e => setNewProductUnitValue(e.target.value)} className="select w-full">
                                <option disabled selected>Unidade de medida</option>
                                <option>QUILOGRAMA</option>
                                <option>LITRO</option>
                                <option>UNIDADE</option>
                            </select>
                            <button type='submit' className='btn btn-primary'>Salvar</button>
                        </div>
                    </div>
                </form>
            </Modal>
        </div>
    )
}

export default AddProduct