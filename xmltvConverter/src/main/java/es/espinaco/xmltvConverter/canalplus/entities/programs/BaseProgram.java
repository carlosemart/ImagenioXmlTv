package es.espinaco.xmltvConverter.canalplus.entities.programs;

import java.util.ArrayList;
import java.util.List;

public class BaseProgram {

	private String description = "";
	private String title;
	private String subTitle;
	private String desc;
	private Credits credits = null;
	private String date;
	private String category;
	private String keyword;
	private String language;
	private String origLanguage;
	private String length;
	private String icon;
	private String url;
	private String country;
	private String episodeNum;
	private String video;
	private String audio;
	private String previouslyShown;
	private String premiere;
	private String lastChance;
	private String nuevo;
	private String subtitles;
	private String rating;
	private String starRating;
	private String review;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Credits getCredits() {
		return credits;
	}

	public void setCredits(Credits credits) {
		this.credits = credits;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getOrigLanguage() {
		return origLanguage;
	}

	public void setOrigLanguage(String origLanguage) {
		this.origLanguage = origLanguage;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEpisodeNum() {
		return episodeNum;
	}

	public void setEpisodeNum(String episodeNum) {
		this.episodeNum = episodeNum;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getPreviouslyShown() {
		return previouslyShown;
	}

	public void setPreviouslyShown(String previouslyShown) {
		this.previouslyShown = previouslyShown;
	}

	public String getPremiere() {
		return premiere;
	}

	public void setPremiere(String premiere) {
		this.premiere = premiere;
	}

	public String getLastChance() {
		return lastChance;
	}

	public void setLastChance(String lastChance) {
		this.lastChance = lastChance;
	}

	public String getNuevo() {
		return nuevo;
	}

	public void setNuevo(String nuevo) {
		this.nuevo = nuevo;
	}

	public String getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(String subtitles) {
		this.subtitles = subtitles;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getStarRating() {
		return starRating;
	}

	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public class Credits {

		private List<String> director = new ArrayList<String>();
		private List<String> actor = new ArrayList<String>();
		private List<String> writer = new ArrayList<String>();
		private List<String> adapter = new ArrayList<String>();
		private List<String> producer = new ArrayList<String>();
		private List<String> composer = new ArrayList<String>();
		private List<String> editor = new ArrayList<String>();
		private List<String> presenter = new ArrayList<String>();
		private List<String> commentator = new ArrayList<String>();
		private List<String> guest = new ArrayList<String>();

		public List<String> getDirector() {
			return director;
		}

		public void setDirector(List<String> director) {
			this.director = director;
		}

		public List<String> getActor() {
			return actor;
		}

		public void setActor(List<String> actor) {
			this.actor = actor;
		}

		public List<String> getWriter() {
			return writer;
		}

		public void setWriter(List<String> writer) {
			this.writer = writer;
		}

		public List<String> getAdapter() {
			return adapter;
		}

		public void setAdapter(List<String> adapter) {
			this.adapter = adapter;
		}

		public List<String> getProducer() {
			return producer;
		}

		public void setProducer(List<String> producer) {
			this.producer = producer;
		}

		public List<String> getComposer() {
			return composer;
		}

		public void setComposer(List<String> composer) {
			this.composer = composer;
		}

		public List<String> getEditor() {
			return editor;
		}

		public void setEditor(List<String> editor) {
			this.editor = editor;
		}

		public List<String> getPresenter() {
			return presenter;
		}

		public void setPresenter(List<String> presenter) {
			this.presenter = presenter;
		}

		public List<String> getCommentator() {
			return commentator;
		}

		public void setCommentator(List<String> commentator) {
			this.commentator = commentator;
		}

		public List<String> getGuest() {
			return guest;
		}

		public void setGuest(List<String> guest) {
			this.guest = guest;
		}

	}

}
