import axios from 'axios'



export function useDogApi() {
    async function obterDogs() {

        axios.get("https://dog.ceo/api/breeds/image/random/10")
            .then(res => {
                this.setState({ dogs: res.data.message })
            })
            .catch(error => {
                console.log(error)
            })
    }
    return {
        obterDogs
    }
}