import Inputs from '@/components/Inputs';
import Table from '@/components/Table';
import { usePost } from '@/hooks/usePost';
import axios from 'axios';
import { useState } from 'react';

const obj = {
  name: '',
  height: '', 
  weight: '',
  resultImc: 0,
  description: '',
}
export default function Home() {
  const [values, setValues] = useState(obj)
  const [objForPost, setObjForPost] = useState()


  const handleChangeValues = (e) => {
    setValues({...values, [e.target.name]: e.target.value})
  }
  const handleClick = () => {
    calculateImc()
    console.log(values)
  }
  const postData = (url, obj) => {
    return axios.post(url, obj).then(res => res.data)
  }

  const calculateImc = () => {
    let height = parseFloat(values.height)
    let weight = parseFloat(values.weight)
    let result = weight / (height * height)
    let resultImc = parseFloat(result.toFixed(2))
   
    if(resultImc <= 18.5){
      setValues({
        name: values.name,
        height: height,
        weight: weight,
        resultImc: resultImc,
        description: "Abaixo do peso"
      })
    }else if(resultImc >= 18.6 && resultImc <=24.9){
      setValues({
        name: values.name,
        height: height,
        weight: weight,
        resultImc: resultImc,
        description: "Peso Ideal (Parabéns)"
      })
    }else if(resultImc >= 25 && resultImc <=29.9){
      setValues({
        name: values.name,
        height: height,
        weight: weight,
        resultImc: resultImc,
        description: "Levemente acima do peso"
      })
    }else if(resultImc >= 30 && resultImc <=34.9){
      setValues({
        name: values.name,
        height: height,
        weight: weight,
        resultImc: resultImc,
        description: "Obesidade Grau I"
      })
    }else if(resultImc >= 35 && resultImc <=39.9){
      setValues({
        name: values.name,
        height: height,
        weight: weight,
        resultImc: resultImc,
        description: "Obesidade Grau II (Severa)"
      })
    }else{
      setValues({
        name: values.name,
        height: height,
        weight: weight,
        resultImc: resultImc,
        description: "Obesidade Grau III (Mórbida)"
      })
    }
    
  }
  
  

  return (
    <main className="flex flex-col items-center h-screen bg-zinc-400">
      <div className="h-1/5 py-8 " >
        <h1 className="text-zinc-900 text-4xl font-bold">Imc Calculator</h1>
      </div>
      <div className=" flex flex-col gap-5">
        <Inputs handleChangeValues = {handleChangeValues} values= {values} handleClick = {handleClick} />
        <Table />
      </div>
    </main>
  )
}
