import { usePost } from '@/hooks/usePost'
import React from 'react'

const Inputs = (props) => {
  const {handleChangeValues, values, handleClick} = props

  return (
    <div className="w-full">
      <div className="flex flex-row justify-center items-center gap-5">
        <input className="p-2 text-xl text-center rounded-md border-none outline-none" 
        placeholder='Seu Nome'
        type="text" 
          name = "name" value={values.name} onChange={handleChangeValues}
        />
        <input className="p-2 text-xl text-center rounded-md border-none outline-none" 
        type="text" placeholder='Sua Altura (m)'
          name = "height" value={values.height} onChange={handleChangeValues}
        />
        <input className="p-2 text-xl text-center rounded-md border-none outline-none" 
        type="text" placeholder = 'Seu Peso (Kg)'
          name = "weight" value={values.weight} onChange={handleChangeValues}
        />
        <button className="py-2 px-4 text-xl font-semibold text-center rounded-md bg-zinc-950 text-white" 
        onClick={() => handleClick()}
        type="text">Calcular</button>
      </div>
    </div>
  )
}

export default Inputs
