import axios from 'axios';

class ApiClient {
  get(url) {
    return axios.get(url)
      .then((response) => {
        return response.data
      })
  }
}

export default ApiClient;