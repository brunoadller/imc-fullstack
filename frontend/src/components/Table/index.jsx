import { useFetch } from '@/hooks/useFetch'
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import {IconTrash} from '@tabler/icons-react'

const Table = () => {
  const { data } = useFetch("http://localhost:8080/api/imcUsers")
  
  return (
    <div>
       {
        data.length === 0? 
        (<h1>Processando</h1>)
        :
        <table className="w-full text-xl rounded-md overflow-hidden">
        <thead>
          <tr className="bg-zinc-900 text-white">
            <th>Id</th>
            <th>Nome</th>
            <th>Altura</th>
            <th>Peso</th>
            <th>Resultado</th>
            <th>Descrição</th>
            <th>Editar</th>
          </tr>
        </thead>
        <tbody>
         {
          data?.map((item, index) => {
            return (
              <tr
              className={`
                text-center
               
                ${index % 2 == 0? 'bg-zinc-700': 'bg-zinc-800 text-white'}
              `}
              key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.height}</td>
                <td>{item.weight}</td>
                <td>{item.resultImc}</td>
                <td>{item.description}</td>
                <td className="flex justify-center items-center">
                  <IconTrash
                  className="
                  my-2
                  bg-zinc-950 rounded-[50%] 
                  cursor-pointer p-2
                  text-white"
                  size={40}/>
                </td>
            </tr>
          
            )
          })
         }
         </tbody>
      </table>
       }
    </div>
  )
}

export default Table