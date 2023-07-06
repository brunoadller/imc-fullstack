import axios from 'axios';
import { useEffect, useState } from 'react';

 export function usePost(url){
  const [data, setData] = useState([])
    axios.post(url, data).then(res => res.data)


    return {setData}
 }
