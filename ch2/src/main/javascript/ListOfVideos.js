import React from "react";

class ListOfVideos extends React.Component {
    constructor(props) {
        super(props)
        this.state = {data: []}
    }

    async componentDidMount() {
        let response = await fetch("/api/videos")
        let json = await response.json()
        this.setState({data: json})
    }

    render() {
        return (
            <ul>
                {this.state.data.map(item =>
                    <li>
                        {item.name}
                    </li>)}
            </ul>
        )
    }
}

export default ListOfVideos
