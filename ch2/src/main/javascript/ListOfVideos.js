import React from "react"

class ListOfVideos extends React.Component {
    constructor(props) {
        super(props)
        this.state = {data: []}
    }

    async componentDidMount() {
        let json = await fetch("/api/videos").then(r => r.json())
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
